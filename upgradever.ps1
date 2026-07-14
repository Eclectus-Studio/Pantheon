# upgradever.ps1

$ErrorActionPreference = "Stop"

Write-Host ""
Write-Host "=== Gradle Version Updater ===" -ForegroundColor Cyan
Write-Host ""

# Find all Gradle-related files
$files = Get-ChildItem -Recurse -File | Where-Object {
    $_.Name -in @(
        "build.gradle",
        "build.gradle.kts",
        "gradle.properties"
    )
}

if (!$files) {
    Write-Host "No Gradle files found."
    exit
}

# Regexes that capture version values
$patterns = @(
    'version\s*=\s*["'']?([^"'']+)["'']?',
    'VERSION_NAME\s*=\s*(.+)$'
)

$versions = New-Object System.Collections.Generic.HashSet[string]

foreach ($file in $files) {

    $lines = Get-Content $file.FullName

    foreach ($line in $lines) {

        foreach ($pattern in $patterns) {

            if ($line -match $pattern) {
                $null = $versions.Add($Matches[1].Trim())
            }
        }
    }
}

if ($versions.Count -eq 0) {
    Write-Host "No versions found."
    exit
}

$list = $versions | Sort-Object

Write-Host "Versions detected:"
Write-Host ""

for ($i=0; $i -lt $list.Count; $i++) {
    Write-Host "[$($i+1)] $($list[$i])"
}

Write-Host ""

if ($list.Count -eq 1) {
    $oldVersion = $list[0]
    Write-Host "Using version: $oldVersion"
}
else {
    do {
        $choice = Read-Host "Choose version number"
    } until (
        $choice -match '^\d+$' -and
        [int]$choice -ge 1 -and
        [int]$choice -le $list.Count
    )

    $oldVersion = $list[[int]$choice-1]
}

$newVersion = Read-Host "Enter new version"

if ([string]::IsNullOrWhiteSpace($newVersion)) {
    Write-Host "Cancelled."
    exit
}

Write-Host ""
Write-Host "Replacing '$oldVersion' -> '$newVersion'"
Write-Host ""

$count = 0

foreach ($file in $files) {

    $text = Get-Content $file.FullName -Raw

    if ($text.Contains($oldVersion)) {

        $updated = $text.Replace($oldVersion, $newVersion)

        if ($updated -ne $text) {
            Set-Content $file.FullName $updated -NoNewline
            Write-Host "Updated $($file.FullName)" -ForegroundColor Green
            $count++
        }
    }
}

Write-Host ""
Write-Host "Done. Updated $count file(s)." -ForegroundColor Green