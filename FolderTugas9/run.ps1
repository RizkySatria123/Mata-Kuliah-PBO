# ============================================================================
# PowerShell Compile and Run Script for Exception Handling Lab
# Tugas Praktikum PBO - Week 9
# ============================================================================

Write-Host "`n========================================"
Write-Host "   Exception Handling Lab - Compiler" -ForegroundColor Cyan
Write-Host "========================================`n"

# Get script directory
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptDir

# Check if Java is installed
try {
    $null = Get-Command javac -ErrorAction Stop
    Write-Host "[INFO] Java compiler found" -ForegroundColor Green
    Write-Host ""
} catch {
    Write-Host "[ERROR] Java compiler (javac) not found!" -ForegroundColor Red
    Write-Host "Please install JDK and add it to PATH." -ForegroundColor Yellow
    Read-Host "Press Enter to exit"
    exit 1
}

# ============================================================================
# Compile Case 1
# ============================================================================
Write-Host "[1/3] Compiling Case 1: CountLetters..." -ForegroundColor Yellow
Set-Location "src\case1"
javac CountLetters.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Failed to compile CountLetters.java" -ForegroundColor Red
    Set-Location ..\..
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "[OK] CountLetters.java compiled successfully`n" -ForegroundColor Green
Set-Location ..\..

# ============================================================================
# Compile Case 2
# ============================================================================
Write-Host "[2/3] Compiling Case 2: ParseInts..." -ForegroundColor Yellow
Set-Location "src\case2"
javac ParseInts.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Failed to compile ParseInts.java" -ForegroundColor Red
    Set-Location ..\..
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "[OK] ParseInts.java compiled successfully`n" -ForegroundColor Green
Set-Location ..\..

# ============================================================================
# Compile Case 3
# ============================================================================
Write-Host "[3/3] Compiling Case 3: Factorials + MathUtils..." -ForegroundColor Yellow
Set-Location "src\case3"
javac MathUtils.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Failed to compile MathUtils.java" -ForegroundColor Red
    Set-Location ..\..
    Read-Host "Press Enter to exit"
    exit 1
}
javac Factorials.java
if ($LASTEXITCODE -ne 0) {
    Write-Host "[ERROR] Failed to compile Factorials.java" -ForegroundColor Red
    Set-Location ..\..
    Read-Host "Press Enter to exit"
    exit 1
}
Write-Host "[OK] Factorials.java and MathUtils.java compiled successfully`n" -ForegroundColor Green
Set-Location ..\..

Write-Host "========================================"
Write-Host "   All cases compiled successfully!" -ForegroundColor Green
Write-Host "========================================`n"

# Interactive menu function
function Show-Menu {
    Write-Host "What would you like to run?`n"
    Write-Host "  1. Case 1 - CountLetters"
    Write-Host "  2. Case 2 - ParseInts"
    Write-Host "  3. Case 3 - Factorials"
    Write-Host "  4. Exit`n"
}

# Main menu loop
$continue = $true
while ($continue) {
    Show-Menu
    $choice = Read-Host "Enter your choice (1-4)"
    
    switch ($choice) {
        "1" {
            Write-Host "`n========================================"
            Write-Host "   Running Case 1: CountLetters" -ForegroundColor Cyan
            Write-Host "========================================`n"
            Set-Location "src\case1"
            java CountLetters
            Set-Location ..\..
        }
        "2" {
            Write-Host "`n========================================"
            Write-Host "   Running Case 2: ParseInts" -ForegroundColor Cyan
            Write-Host "========================================`n"
            Set-Location "src\case2"
            java ParseInts
            Set-Location ..\..
        }
        "3" {
            Write-Host "`n========================================"
            Write-Host "   Running Case 3: Factorials" -ForegroundColor Cyan
            Write-Host "========================================`n"
            Set-Location "src\case3"
            java Factorials
            Set-Location ..\..
        }
        "4" {
            $continue = $false
            Write-Host "`nThank you for using the Exception Handling Lab!`n" -ForegroundColor Green
        }
        default {
            Write-Host "`n[ERROR] Invalid choice. Please enter 1-4.`n" -ForegroundColor Red
        }
    }
    
    if ($continue) {
        Write-Host "`n========================================"
    }
}

Read-Host "Press Enter to exit"
