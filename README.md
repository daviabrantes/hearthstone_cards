# Hearthstone

Aplicativo Android simples que permite exibição de cards do jogo Hearthstone de acordo com o filtro selecionado.
API utilizada: https://hearthstoneapi.com/

# Observações:

A chamada para buscar por todos os cards (sem utilizar parâmetros) é extremamente demorada. Devido a esse problema, utilizei filtros em botões na tela inicial para realizar chamadas mais rápidas.

Diversas imagens hosteadas estão retornando erro, evitando que muitas delas sejam exibidas no aplicativo.

## Stack utilizada

**MVVM** - Architecture

**Coroutines** - Async tasks

**View Binding** - View interaction

**Retrofit** - HTTP requests

**Navigation** - UI navigator

**Koin** - Service Locator (DI)

**Glide** - Image renderer

**Mockk**  - Mocking

**Junit** - Testing

## Melhorias

- Aumento da cobertura de testes
- Implementação de databinding
- Arquivo "dimens" para padronizar componentes de layout
- Migração para Jetpack Compose
