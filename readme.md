# Projeto: Criptografia e Descriptografia com DES e Base64

**Desenvolvido por:** Geraldo Lucas Bezerra Rocha  
**Disciplina:** IMD0703 - SEGURANÇA DE REDES - T02  
**DES com base64 para criptografia e descriptografia**  
**Universidade Federal do Rio Grande do Norte (UFRN)**  
**Professor:** Anderson Claudio Rodrigues Da Silva

## Descrição

Este programa em Java realiza a criptografia e descriptografia de mensagens utilizando o algoritmo **DES (Data Encryption Standard)** em modo **ECB (Electronic Codebook)** com preenchimento **PKCS5Padding** e codificação **Base64** para facilitar a manipulação de dados binários como texto.

## Funcionalidades

1. **Criptografia** de uma mensagem de texto usando a cifra simétrica DES.
2. **Conversão para Base64** para facilitar o transporte e a visualização dos dados cifrados.
3. **Descriptografia** da mensagem usando a mesma chave e o mesmo algoritmo.
4. **Recuperação** exata do texto original após o processo de criptografia e decodificação.
5. **Segurança de chave**: A chave de criptografia deve conter exatamente 8 bytes (requisito do DES).

## Tecnologias Utilizadas

- Linguagem: **Java**
- API de criptografia: **javax.crypto**
- Codificação: **Base64 (java.util.Base64)**
- Charset: **UTF-8**

## Etapas Implementadas

1. O usuário define uma chave de 8 caracteres.
2. A mensagem em texto claro é convertida para bytes com charset UTF-8.
3. A cifra DES é configurada com o modo ECB e preenchimento PKCS5.
4. A mensagem é criptografada e convertida para Base64.
5. A string cifrada em Base64 é impressa na tela.
6. A mensagem criptografada é decodificada de Base64.
7. O mesmo algoritmo DES é usado para reverter o processo e recuperar o texto original.
8. A mensagem original é exibida para confirmar a integridade do processo.

## Exemplo de Saída

```text
Texto criptografado: c8+AvP1t9lYQ+RaB84S7bQ==
Texto descriptografado: Hello, World!
