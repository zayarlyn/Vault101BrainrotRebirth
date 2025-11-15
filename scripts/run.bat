@echo off
cd /d "%~dp0"

echo Starting Vault 101: Brainrot Rebirth...

REM Check if build directory exists
if not exist "build" (
    echo Build directory not found. Running build script first...
    call build.bat
    if %errorlevel% neq 0 (
        echo Build failed. Cannot run the game.
        pause
        exit /b 1
    )
)

REM Run the game
cd build
java game.Vault101BrainrotRebirth
pause