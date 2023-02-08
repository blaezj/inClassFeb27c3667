JFLAGS = -d bin -sourcepath src
JUNIT5_JAR = lib/junit-platform-console-standalone-1.8.2.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar lib/checkstyle-10.5.0-all.jar 

default: 
	@echo "usage: make target"
	@echo "4 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - builds codebase"
	@echo "____________________ test - runs JUnit5 tests"
	@echo "____________________ demo - runs demo (client)"

compile: $(JUNIT5_JAR)
	javac $(JFLAGS) -cp $(JUNIT5_JAR) src/**/**/*.java

test: $(JUNIT5_JAR)
	java -cp bin:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

demo: bin/lpgs/Demo.class
	java -cp bin lpgs/Demo

clean:
	rm -f ./bin/**/*.class
