# Define Java compiler
JCC = javac

# Define Java compiler
JCC = javac

# Define Java runtime
JVM = java

# Specify the source, documentation, and bin directories
SRC_DIR = src/main
TEST_DIR = src/test
DOC_DIR = docs
BIN_DIR = bin
LIB_DIR = lib




# Java source files
SOURCES = $(SRC_DIR)/Project3.java \
          $(SRC_DIR)/BinaryTree.java \
		  $(SRC_DIR)/TreeSyntaxException.java \
          $(TEST_DIR)/Project3Test.java \
          $(TEST_DIR)/BinaryTreeTest.java \
          $(TEST_DIR)/TreeSyntaxExceptionTest.java \
          $(TEST_DIR)/TestRunner.java

# Default target
all: compile run_tests run_project

# Rule to compile .class files in the bin directory
compile:
	@echo "Compiling Java sources..."
	mkdir -p $(BIN_DIR)
	$(JCC) -d $(BIN_DIR) -cp src $(SOURCES)
	@echo "Compilation complete."

# Rule to generate TXT file


# Rule to compile and run tests
run_tests: compile
	cd $(BIN_DIR) && $(JVM) -cp .:../$(SRC_DIR) test.TestRunner



# Rule to compile and run project
run_project: compile
	cd $(BIN_DIR) && $(JVM) -cp .:../$(SRC_DIR) main.Project3

# Rule to clean up
clean:
	rm -rf $(DOC_DIR)/*.txt
	rm -rf $(BIN_DIR)
