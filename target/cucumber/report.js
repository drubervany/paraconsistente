$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("first.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 3,
  "name": "Testar as operacoes basicas de conta",
  "description": "O sistema deve prover o saque e deposito na conta de forma correta.\nSeguindo as seguintes restrições:\n1) Só libera o saque, se o valor do saque for menor ou igual ao valor \n    do saldo disponível na conta\n2) Só libera o deposito, se o valor do deposito for menor ou igual ao \n    valor do limite disponível na conta",
  "id": "testar-as-operacoes-basicas-de-conta",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@ContaTeste"
    }
  ]
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Testar saque e deposito",
  "description": "",
  "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario"
});
formatter.step({
  "line": 12,
  "name": "a conta criada para o dono \"\u003cdono\u003e\" de numero \u003cnumero\u003e com o limite \u003climite\u003e e saldo \u003csaldo\u003e",
  "keyword": "Dado "
});
formatter.step({
  "line": 13,
  "name": "o dono realiza o deposito no valor de \u003cdeposito\u003e na conta",
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "o dono realiza o primeiro saque no valor de \u003cprimeiro_saque\u003e na conta",
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "o dono realiza o segundo saque no valor de \u003csegundo_saque\u003e na conta",
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "o dono tem o saldo no valor de \u003csaldo_esperado\u003e na conta",
  "keyword": "Entao "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;",
  "rows": [
    {
      "cells": [
        "dono",
        "numero",
        "limite",
        "saldo",
        "deposito",
        "primeiro_saque",
        "segundo_saque",
        "saldo_esperado"
      ],
      "line": 19,
      "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;;1"
    },
    {
      "cells": [
        "Brendo",
        "111",
        "1000",
        "0",
        "100",
        "10",
        "10",
        "80"
      ],
      "line": 20,
      "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;;2"
    },
    {
      "cells": [
        "Hiago",
        "222",
        "1000",
        "0",
        "200",
        "10",
        "10",
        "180"
      ],
      "line": 21,
      "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;;3"
    }
  ],
  "keyword": "Exemplos"
});
formatter.scenario({
  "line": 20,
  "name": "Testar saque e deposito",
  "description": "",
  "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 2,
      "name": "@ContaTeste"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "a conta criada para o dono \"Brendo\" de numero 111 com o limite 1000 e saldo 0",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "Dado "
});
formatter.step({
  "line": 13,
  "name": "o dono realiza o deposito no valor de 100 na conta",
  "matchedColumns": [
    4
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "o dono realiza o primeiro saque no valor de 10 na conta",
  "matchedColumns": [
    5
  ],
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "o dono realiza o segundo saque no valor de 10 na conta",
  "matchedColumns": [
    6
  ],
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "o dono tem o saldo no valor de 80 na conta",
  "matchedColumns": [
    7
  ],
  "keyword": "Entao "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 21,
  "name": "Testar saque e deposito",
  "description": "",
  "id": "testar-as-operacoes-basicas-de-conta;testar-saque-e-deposito;;3",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 2,
      "name": "@ContaTeste"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "a conta criada para o dono \"Hiago\" de numero 222 com o limite 1000 e saldo 0",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "Dado "
});
formatter.step({
  "line": 13,
  "name": "o dono realiza o deposito no valor de 200 na conta",
  "matchedColumns": [
    4
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 14,
  "name": "o dono realiza o primeiro saque no valor de 10 na conta",
  "matchedColumns": [
    5
  ],
  "keyword": "E "
});
formatter.step({
  "line": 15,
  "name": "o dono realiza o segundo saque no valor de 10 na conta",
  "matchedColumns": [
    6
  ],
  "keyword": "E "
});
formatter.step({
  "line": 16,
  "name": "o dono tem o saldo no valor de 180 na conta",
  "matchedColumns": [
    7
  ],
  "keyword": "Entao "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});