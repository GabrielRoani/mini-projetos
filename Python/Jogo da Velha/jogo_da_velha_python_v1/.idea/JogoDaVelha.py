def jogar():
    import random

    imprime_msg_abertura()

    ganhou = False
    perdeu = False
    velha = False

    start = sorteador_de_inicio()

    demonstracao_de_posicao()

    matriz = [["_","_","_"],
              ["_","_","_"],
              ["_","_","_"]]
    #teste de inicialização da ordem de jogada
    #print(start)
    ordem = primeira_jogada(start, matriz)

    while (not ganhou and not perdeu and not velha):
        if(ordem ==0):
            print("SUA VEZ!")
            linha = int(input("Insira o numero da linha"))
            coluna = int(input("Insira o numero da coluna"))
            matriz[linha][coluna] = ("X")
            for n in range(0, 3):
                print(matriz[n])
            ordem = ordem + 1
            print("\n")
        else:
            print("\nVez da Maquina")
            linha = random.randrange(0, 3)
            coluna = random.randrange(0, 3)
            matriz[linha][coluna] = "O"
            for n in range(0, 3):
                print(matriz[n])
            ordem = ordem - 1




def imprime_msg_abertura():
    print("*********************************")
    print("Bem vindo ao jogo da velha!")
    print("********************************* \n")

def sorteador_de_inicio():
    import random

    on = int(input("Está pronto para começar ? (1) Sim (2) Não\n"))
    while(on != 1):
        on = int(input("Já está pronto? Aperte 1 para iniciar o jogo"))
    print("Sortearemos agora se você começa ou a maquina.")
    sorteio = random.randrange(0,2)
    if(sorteio == 1):
        print("Você vai começar jogando e usara o X")
    else:
        print("Preparado para perder ? A maquina começa")
    return sorteio

def demonstracao_de_posicao():
    print("Essa é a demonstração das posições possiveis:\n")
    print("0,0","|","0,1","|","0,2")
    print("1,0","|","1,1","|","1,2")
    print("2,0","|","2,1","|","2,2")

def primeira_jogada(start,matriz):
    import random
    if(start == 1):
        print("Vez do Jogador")
        linha = int(input("Insira o numero da linha"))
        coluna = int(input("Insira o numero da coluna"))
        matriz[linha][coluna] = ("X")
        for n in range(0,3):
            print(matriz[n])
        ordem = 1
    else:
        print("Vez da Maquina")
        linha = random.randrange(0,3)
        coluna = random.randrange(0,3)
        matriz[linha][coluna] = "O"
        for n in range(0,3):
            print(matriz[n])
        ordem = 0
    return ordem

if(__name__ == "__main__"):
    jogar ()