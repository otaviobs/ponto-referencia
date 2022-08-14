# Posições dos veiculos de acordo com um ponto de referencia

Descrição 
Determinado cliente possui interesse em saber quanto tempos seus veículos ficaram em 
determinadas regiões. Para isso, esse cliente cadastrou seus pontos de interesse (POIs) no 
sistema e agora deseja visualizar numa interface web o tempo que cada veículo permaneceu 
nos pontos cadastrados. Você será responsável por efetuar essa entrega para ele.

Empresa Moby7:
[Code_Task_Description.pdf](https://github.com/otaviobs/ponto-referencia/files/9275048/Code_Task_Description.pdf)


# Instruções para rodar:
No projeto pode usar o Docker Compose para subir o ambiente com o PostgreSQL+Postgis e a API REST
```
docker-compose up --build -d
```

Poderá consultar a documentação da API usando o Swagger com o endereço: http://localhost:8081/swagger-ui/index.html
