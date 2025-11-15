#!/bin/bash

# Build script for Vault 101: Brainrot Rebirth
# This script compiles all Java files in the proper package structure

echo "Building Vault 101: Brainrot Rebirth..."

# Create build directory if it doesn't exist
mkdir -p build

# Compile all Java files with proper classpath
javac -d build -cp . interfaces/*.java characters/*.java enemies/*.java main/*.java

if [ $? -eq 0 ]; then
    echo "Build successful!"
else
    echo "Build failed!"
    exit 1
fi
