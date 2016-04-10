all:
	javac pm/estacionamento/**/*.java
	javac pm/estacionamento/*.java

clean:
	rm -rf pm/estacionamento/**/*.class
	rm -rf pm/estacionamento/*.class

run:
	java pm/estacionamento/Main


# Testes

test_%:
	@echo "\n! Testando \"$@\""
	java pm/estacionamento/Main < test/$@/in.txt > test/$@/$@.log
	diff test/$@/out.txt test/$@/$@.log

test: test_normal test_lotado test_veiculo_invalido
