numero1 = float(input("Informe o primeiro número: "))
numero2 = float(input("Informe o segundo número: "))
numero3 = float(input("Informe o terceiro número: "))
if numero1 > numero2 and numero1 > numero3:
    maior = numero1
if numero2 > numero3 and numero2 > numero1:
    maior = numero2
if numero3 > numero2 and numero3 > numero2:
    maior = numero3
print(f"O maior número digitado foi {maior}")
