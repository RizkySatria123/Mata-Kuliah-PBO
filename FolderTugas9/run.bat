@echo off
REM ============================================================================
REM Compile and Run Script for Exception Handling Lab
REM Tugas Praktikum PBO - Week 9
REM ============================================================================

setlocal

echo.
echo ========================================
echo   Exception Handling Lab - Compiler
echo ========================================
echo.

REM Get the script directory
set "SCRIPT_DIR=%~dp0"
cd /d "%SCRIPT_DIR%"

REM Check if Java is installed
where javac >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java compiler (javac) not found!
    echo Please install JDK and add it to PATH.
    pause
    exit /b 1
)

echo [INFO] Java compiler found
echo.

REM ============================================================================
echo [1/3] Compiling Case 1: CountLetters...
REM ============================================================================
cd src\case1
javac CountLetters.java
if %errorlevel% neq 0 (
    echo [ERROR] Failed to compile CountLetters.java
    cd ..\..
    pause
    exit /b 1
)
echo [OK] CountLetters.java compiled successfully
cd ..\..
echo.

REM ============================================================================
echo [2/3] Compiling Case 2: ParseInts...
REM ============================================================================
cd src\case2
javac ParseInts.java
if %errorlevel% neq 0 (
    echo [ERROR] Failed to compile ParseInts.java
    cd ..\..
    pause
    exit /b 1
)
echo [OK] ParseInts.java compiled successfully
cd ..\..
echo.

REM ============================================================================
echo [3/3] Compiling Case 3: Factorials + MathUtils...
REM ============================================================================
cd src\case3
javac MathUtils.java
if %errorlevel% neq 0 (
    echo [ERROR] Failed to compile MathUtils.java
    cd ..\..
    pause
    exit /b 1
)
javac Factorials.java
if %errorlevel% neq 0 (
    echo [ERROR] Failed to compile Factorials.java
    cd ..\..
    pause
    exit /b 1
)
echo [OK] Factorials.java and MathUtils.java compiled successfully
cd ..\..
echo.

echo ========================================
echo   All cases compiled successfully!
echo ========================================
echo.
echo What would you like to run?
echo.
echo   1. Case 1 - CountLetters
echo   2. Case 2 - ParseInts
echo   3. Case 3 - Factorials
echo   4. Exit
echo.

choice /c 1234 /n /m "Enter your choice (1-4): "

if errorlevel 4 goto :end
if errorlevel 3 goto :case3
if errorlevel 2 goto :case2
if errorlevel 1 goto :case1

:case1
echo.
echo ========================================
echo   Running Case 1: CountLetters
echo ========================================
echo.
cd src\case1
java CountLetters
cd ..\..
goto :menu

:case2
echo.
echo ========================================
echo   Running Case 2: ParseInts
echo ========================================
echo.
cd src\case2
java ParseInts
cd ..\..
goto :menu

:case3
echo.
echo ========================================
echo   Running Case 3: Factorials
echo ========================================
echo.
cd src\case3
java Factorials
cd ..\..
goto :menu

:menu
echo.
echo ========================================
echo.
echo Run another case?
echo.
echo   1. Case 1 - CountLetters
echo   2. Case 2 - ParseInts
echo   3. Case 3 - Factorials
echo   4. Exit
echo.

choice /c 1234 /n /m "Enter your choice (1-4): "

if errorlevel 4 goto :end
if errorlevel 3 goto :case3
if errorlevel 2 goto :case2
if errorlevel 1 goto :case1

:end
echo.
echo Thank you for using the Exception Handling Lab!
echo.
pause
