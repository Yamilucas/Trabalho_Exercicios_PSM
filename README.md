Projeto desenvolvido para a disciplina de **Programação para Dispositivos Móveis**, sobre o cadastro e gerenciamento de exercícios de treino de academia.

## Autores
- **Lucas Eufrásio Guimarães**
- **Rodrian**

## Descrição do Projeto
O sistema consiste em uma aplicação mobile para **cadastro, listagem e exclusão de exercícios de treino de academia**, com armazenamento de dados em nuvem.

A aplicação foi desenvolvida no **Android Studio**, utilizando a linguagem de programação **Kotlin**, o **Jetpack Compose** para a construção da interface gráfica e o **Firebase Cloud Firestore** como banco de dados em nuvem da aplicação.

## Estrutura do Projeto
O projeto está organizado na seguinte estrutura de arquivos:
- **google-services.json** – Arquivo de configuração que permite a integração com o banco de dados **Firebase**
- **CaixaDeTexto.kt** – Componente gráfico desenvolvido com **Jetpack Compose**, utilizado na interface da aplicação
- **ExerciciosDataSource.kt** – Responsável por gerenciar os dados (cadastro, listagem e exclusão) no **Firebase**
- **Exercicio.kt** – Classe que representa os atributos do exercício
- **Color.kt** – Definição das cores utilizadas na interface gráfica com **Jetpack Compose**
- **Theme.kt** – Configuração do tema e esquema de cores da interface gráfica com **Jetpack Compose**
- **Type.kt** – Configuração das fontes da interface gráfica utilizando **Jetpack Compose**
- **MainActivity.kt** – Inicializa o Firebase, configura a navegação e o preview da interface gráfica

## Funcionalidades
- Cadastro de exercícios contendo:
  - Nome do exercício
  - Carga ou velocidade
  - Repetições ou distância
- Listagem dinâmica dos exercícios cadastrados na nuvem pelo Firebase (Cloud Firestore)
- Exclusão de exercícios
 
## Tecnologias Utilizadas
- **Kotlin**
- **Android Studio**
- **Jetpack Compose**
- **Firebase**
- **Cloud Firestore**

## Estrutura de Execução
- Aplicação executada em dispositivo ou emulador **Android** do **Android Studio**
- Comunicação direta com o banco de dados em nuvem via **Firebase**
- Atualização automática da interface conforme alterações no banco


