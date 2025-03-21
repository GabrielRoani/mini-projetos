import random


def jogar():
    imprime_msg_abertura()

    start = sorteador_de_inicio()

    demonstracao_de_posicao()

    matriz = [["_","_","_"],
              ["_","_","_"],
              ["_","_","_"]]

    ordem = primeira_jogada(start, matriz)

    while (not fim_jogo(matriz)):
        if(ordem == 0):
            print("SUA VEZ!")
            linha, coluna = get_input(matriz)
            matriz[linha][coluna] = "X"
            mostra_matriz(matriz)
            ordem = 1
        else:
            print("\nVez da Maquina")
            linha, coluna = random.choice(get_lista_posicoes_possiveis(matriz))
            matriz[linha][coluna] = "O"
            mostra_matriz(matriz)
            ordem = 0


def fim_jogo(matriz):
    if verifica_vitoria(matriz):
        print("Ganhou")
        return True
    if verifica_derrota(matriz):
        print("Perdeu")
        return True
    if verifica_velha(matriz):
        print("Velha")
        return True
    return False


def verifica_vitoria(matriz):
    return False


def verifica_derrota(matriz):
    return False


def verifica_velha(matriz):
    if len(get_lista_posicoes_possiveis(matriz)) == 0:
        return True
    return False


def get_input(matriz):
    posicoes_disponiveis = get_lista_posicoes_possiveis(matriz)
    while True:
        try:
            linha = int(input("Insira o numero da linha: "))
            coluna = int(input("Insira o numero da coluna: "))
            if (linha, coluna) in posicoes_disponiveis:
                return (linha, coluna)
            print("Posicao ja ocupada ou invalida")
        except ValueError:
            print("Erro")


def mostra_matriz(matriz):
    for n in range(0, 3):
        print(matriz[n])


def imprime_msg_abertura():
    print("*********************************")
    print("Bem vindo ao jogo da velha!")
    print("********************************* \n")


def sorteador_de_inicio():
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


def primeira_jogada(start, matriz):
    if(start == 1):
        print("Vez do Jogador")
        linha, coluna = get_input(matriz)
        matriz[linha][coluna] = "X"
        mostra_matriz(matriz)
        ordem = 1
    else:
        print("Vez da Maquina")
        linha, coluna = random.choice(get_lista_posicoes_possiveis(matriz))
        matriz[linha][coluna] = "O"
        mostra_matriz(matriz)
        ordem = 0
    return ordem


def get_lista_posicoes_possiveis(matriz):
    result = []
    for i in range(3):
        for j in range(3):
            if matriz[i][j] == "_":
                result.append((i, j))
    return result


if (__name__ == "__main__"):
    jogar ()