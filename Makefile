all: build

build:
	javac pm/estacionamento/**/*.java
	javac pm/estacionamento/*.java

clean:
	rm -rf pm/estacionamento/**/*.class
	rm -rf pm/estacionamento/*.class
	rm -rf doc/*.aux
	rm -rf doc/*.log
	rm -rf doc/*.pdf

run:
	java pm/estacionamento/Main

# Documentação
doc:
	pdflatex -output-directory=doc doc/doc.tex
	cp doc/doc.pdf Estacionamento_ArthurXavier_AlexandrePretti_Vitor.pdf

# Testes
test_%:
	@echo "\n! Testando \"$@\""
	java pm/estacionamento/Main < test/$@/in.txt > test/$@/$@.log
	diff test/$@/out.txt test/$@/$@.log

test: test_normal test_lotado test_invalido

.PHONY: clean doc
