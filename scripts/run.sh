#!/bin/bash

# Run script for Vault 101: Brainrot Rebirth

echo "Starting Vault 101: Brainrot Rebirth..."

# Check if build directory exists
if [ ! -d "build" ]; then
    echo "Build directory not found. Running build script first..."
    ./build.sh
    if [ $? -ne 0 ]; then
        echo "Build failed. Cannot run the game."
        exit 1
    fi
fi

# Run the game
# cd build && java game.Vault101BrainrotRebirth
cd build && java Vault101BrainrotRebirth
