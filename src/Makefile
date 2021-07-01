SOURCES = $(wildcard klassen/*.java)
SOURCES_CLASS = $(SOURCES:.java=.class)
JAVAC = javac

install: compile Manifest.mf
	jar cmf Manifest.mf Out.jar $(SOURCES_CLASS)

clean:
	rm $(SOURCES_CLASS) *.mf

compile: $(SOURCES)
	$(JAVAC) $(SOURCES)

run: compile 
	java Main

prepare:
	sudo apt install openjdk-16-jdk-headless

Manifest.mf:
	echo "Main-Class: Main" >> Manifest.mf

all: prepare compile run
