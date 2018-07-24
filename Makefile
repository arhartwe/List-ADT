#-----------------------------------------------------------------------------
#
# Makefile for CMPS 101 pa1
# Compiles all .java files in the current directory and creates an executable
# jar file called Lex. 
#
# Name: 	Andrew Hartwell
# CruzID:	arhartwe
# Assignment:	pa1
#-----------------------------------------------------------------------------

MAINCLASS	= Lex
JAVAC		= javac
JAVASRC 	= $(wildcard *.java)
SOURCES 	= $(JAVASRC) makefile README
CLASSES 	= $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES 	= $(patsubst %.class, %*.class, $(CLASSES))
JARFILE 	= $(MAINCLASS)

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class $(JARFILE)