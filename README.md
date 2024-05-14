# NextFlix
Com as séries que amamos espalhadas em diversas plataformas, é fácil se perder entre quais séries você está assistindo e em qual episódio parou. 
Apesar de a maioria das plataformas guardar essa informação, ela nem sempre é confiável, especialmente quando se divide as contas com outras pessoas. 

A NextFlix chegou para que você possa centralizar o controle das séries que você gosta em um só lugar. Navegue no Catálogo das séries, salve as que te interessam na sua Watchlist, e marque os episódios assistidos. 

## Informações técnicas
- 100% Kotlin
- Jetpack Compose com navegação
- Arquitetura MVVM
- Retrofit + Kotlin Serialization para comunicação com API
- Coroutines para operações assíncronas
- Hilt para injeção de dependências
- Coil para carregamento de imagens
- Android Paging 3 para paginação com scroll infinito
- JUnit + Mockito para testes unitários

  
## Implementações futuras
### Funcionais
- Armazenar Watchlist com Room
- Tela de detalhe da série: mais informações da série, lista de episódios para marcar e desmarcar
- Feedback no botão de salvar série na Watchlist
- Ícone do aplicativo
- Tela de perfil: estatísticas do perfil, séries/episódios assistidos

### Não funcionais
- Utilizar RemoteMediator na paginação
- Organizar stubs de previews e testes
- Testes de instrumentação
