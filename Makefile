# Makefile

# Default target
all: lock-all

# Generate lock files for all targets in one command
lock-all:
	./gradlew :composeApp:dependencies --write-locks
	#./gradlew :composeApp:iosX64:dependencies --write-locks && \
	#./gradlew :composeApp:iosArm64:dependencies --write-locks

# Clean target (optional)
clean:
	./gradlew clean

# Phony targets
.PHONY: all lock-all clean
