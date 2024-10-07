
# MedFutura Desafio 

Neste repositorio se encontra as respostas ao desafio solicitado pela empresa MedFutura com o objetivo de avaliar e dar segmento ao processo de candidatura a vaga de estágiario

## Rodar Localmente

Clone o projeto

```bash
  git clone https://github.com/Daniel-Ugulino/test_medFutura
```

Vá ao diretorio do projeto

```bash
  cd test_medFutura
```
Execute o arquivo run.sh
```bash
  bash ./run.sh
```

Endereço dos endpoints:
```bash
  http://localhost:8080/pessoa
```

Documentação dos endpoints
```bash
  http://localhost:8080/swagger-ui/index.html
```
## Ambiente

Instalar Docker

```bash
  Linux: https://docs.docker.com/engine/install/ubuntu/
  Windows: https://docs.docker.com/desktop/install/windows-install/
```
## Endpoints

#### Cadastrar Pessoa

```http
  POST /pessoa
```
#### Buscar Pessoa por Id

```http
  GET /pessoa/${id}
```
#### Buscar Pessoa por Termo

```http
  GET /pessoa/?t
```

#### Atualizar Pessoa

```http
  PUT /pessoa/${id}
```

#### Deletar Pessoa

```http
  DELETE /pessoa/${id}
```
