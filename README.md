# Vault 101: Brainrot Rebirth

## 🎯 How to Play

See **GUIDE.md** for detailed game features and gameplay instructions.

## 📋 Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**:
  - macOS/Linux (use `.sh` scripts)
  - Windows (use `.bat` scripts)

## 🚀 Quick Start

### For macOS/Linux Users:

1. **Navigate to the project directory**:

   ```bash
   cd /path/to/Vault101BrainrotRebirth
   ```

2. **Make scripts executable** (first time only):

   ```bash
   chmod +x scripts/build.sh scripts/run.sh
   ```

3. **Build the game**:

   ```bash
   ./scripts/build.sh
   ```

4. **Run the game**:
   ```bash
   ./scripts/run.sh
   ```

### For Windows Users:

1. **Navigate to the project directory**:

   ```cmd
   cd C:\path\to\Vault101BrainrotRebirth
   ```

2. **Build the game**:

   ```cmd
   scripts\build.bat
   ```

3. **Run the game**:
   ```cmd
   scripts\run.bat
   ```

## 📁 Project Structure

```
Vault101BrainrotRebirth/
├── characters/          # Player character classes
│   ├── Player.java
│   ├── TralaleroTralala.java
│   ├── TungTungTungSahur.java
│   └── CappuccinoAssassino.java
├── enemies/            # Enemy classes
│   ├── Crawler.java
│   ├── Brute.java
│   ├── Screecher.java
│   └── OvergrownBrute.java
├── main/               # Core game logic and systems
│   ├── Vault101BrainrotRebirth.java  # Main game class
│   ├── Map.java                       # Map navigation
│   ├── CoreCombat.java               # Combat system
│   ├── LootSystem.java               # Inventory management
│   └── BaseStats.java                # Base stats implementation
├── interfaces/         # Interface definitions
│   ├── ICoreStats.java
│   ├── IPlayerEntity.java
│   ├── IEnemyEntity.java
│   ├── IGroundUnit.java
│   └── IFlyingUnit.java
├── scripts/            # Build and run scripts
│   ├── build.sh
│   └── run.sh
├── build/              # Compiled class files (generated)
├── GUIDE.md            # Game description and features
└── README.md           # This file
```

## 🛠️ Development

### Building from Source

The project uses a package-based structure following Java best practices:

- **Interfaces**: Define contracts with `I` prefix naming convention
- **Base Classes**: Provide common functionality through concrete implementations
- **Package Organization**: Logical separation of concerns

### Compile Commands

**Manual compilation** (if you prefer not to use scripts):

```bash
# Create build directory
mkdir -p build

# Compile all Java files
javac -d build -cp . \
    interfaces/*.java \
    characters/*.java \
    enemies/*.java \
    main/*.java

# Run the game
cd build && java main.Vault101BrainrotRebirth
```

### Clean Build

To start fresh:

**macOS/Linux**:

```bash
rm -rf build
./scripts/build.sh
```

**Windows**:

```cmd
rmdir /s /q build
scripts\build.bat
```

## 🐛 Troubleshooting

### "javac: command not found" or "java: command not found"

- Ensure JDK is installed: `java -version` and `javac -version`
- Add Java to your PATH environment variable

### "Permission denied" (macOS/Linux)

- Make scripts executable: `chmod +x scripts/*.sh`

### "Build failed" errors

- Check that all `.java` files are present
- Verify you're in the project root directory
- Ensure no syntax errors in source files

### Game won't start

- Make sure you've built the project first using `build.sh` or `build.bat`
- Check that the `build/` directory exists and contains `.class` files

## 📝 Notes

- The game saves are not persistent (restarting will reset progress)
- All game data is stored in memory during runtime
- Build output is stored in the `build/` directory (excluded from version control)

## 🎓 Credits

Game developed as a Java programming project demonstrating object-oriented principles, package organization, and game development fundamentals.

---

**Enjoy your adventure in Vault 101: Brainrot Rebirth!** 🎮
