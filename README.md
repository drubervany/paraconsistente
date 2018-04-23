# **Paraconsistente**

**Documento de configuração de ambiente de desenvolvimento**


| **AUTOR** | **VERSÃO** | **DATA** | **COMENTÁRIOS** |
| --- | --- | --- | --- |
| Danilo R. Dias | 1.0 | 18/04/2018 | Criação do documento |


* [Introdução](#introdução)
* [GIT](#git)  
* [JAVA](#java)
* [MAVEN](#maven)  
* [Docker](#docker)
* [Eclipse](#eclipse)
* [Plugins do Eclipse](#plugins-do-eclipse)

## Introdução 

Este guia tem como objetivo apresentar os procedimentos necessários para configurar a estação de trabalho de desenvolvimento.

----
	
## GIT 
  1. [https://github.com/git-for-windows/git/releases/tag/v2.10.1.windows.1](https://github.com/git-for-windows/git/releases/tag/v2.10.1.windows.1)
  2. Instalar o Git 2.10.1  
  ![Imagem 1](./img/GIT1.png)  
  ![Imagem 2](./img/GIT2.png)  
  ![Imagem 3](./img/GIT3.png)  
  ![Imagem 4](./img/GIT4.png)  
  ![Imagem 5](./img/GIT5.png)
  3. Desmarcar a opção "Enable Git Credencial Manager"  
  ![Imagem 6](./img/GIT6.png)
  4. Abrir um terminal em modo admin setar algumas variáveis do GIT. O nome e e-mail serão associados com os seus commits:  
  git config --global user.name "digitar-seu-nome"  
  git config --global user.email "digitar-seu-email"  
  git config --system core.longpaths true  
  
----

## JAVA 
  1. Instalar **java 1.8 - jdk-8u112-windows-x64** [http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html)
  2. Configurar variáveis de ambiente:
    1. **JAVA\_HOME** : C:\Program Files\Java\jdk1.8.0\_112
    2. **JDK\_HOME**  : %JAVA\_HOME%
    3. **JRE\_HOME**  : %JAVA\_HOME%\jre
    4. **CLASSPATH** : .;%JAVA\_HOME%\lib;%JAVA\_HOME%\jre\lib
    5. **PATH**      : your-unique-entries;%JAVA\_HOME%\bin
  3. Após configurar abra um terminal e digite 'java -version'  
  ![Imagem 7](./img/JAVA1.png)
  
  ----
  
## MAVEN
  1. Baixe o [Maven!][maven]. 
  2. Instalar maven 3.3.9 no diretório c:\apps  
  ![Imagem 8](./img/MAVEN1.png)
  3. Configurar as variáveis de ambiente do Maven:
    1. **M2_HOME** :C:\apps\apache-maven-3.3.9
    2. **M2** : %M2_HOME%\bin
    3. **MAVEN_OPTS** : -Xms256m -Xmx512m
    4. **PATH** :your-unique-entries; %M2%
  4. Em C:\apps\apache-maven-3.3.9\conf, renomeie o arquivo settings.xml para settings.xml.old
  5. Baixe o arquivo [settings.xml](./maven/settings.xml) (que está configurado para utilizar o nosso Nexus) e jogue nessa pasta de conf
  6. Após configurar abra um terminal e digite mvn -version  
  ![Imagem 9](./img/MAVEN2.png)

[maven]: http://ftp.unicamp.br/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip

----

## DOCKER

  1. Baixar o docker em [Docker!][Docker] 
  2. Extrair o zip DockerToolbox-1.13.0.zip  
  ![Imagem 10](./img/DOCKER1.png)
  3. Instalar o Docker em *C:\Program Files\Docker Toolbox  
  ![Imagem 11](./img/DOCKER2.png)
  4. Selecione as opções conforme imagem abaixo e prossiga  
  ![Imagem 12](./img/DOCKER3.png)
  5. Selecione as opções conforme imagem abaixo e prossiga  
  ![Imagem 13](./img/DOCKER4.png)
  6. Clique em 'Install'  
  ![Imagem 14](./img/DOCKER5.png)
  7. Clique em 'Finish'  
  ![Imagem 15](./img/DOCKER6.png)

[Docker]: https://github.com/docker/toolbox/releases/tag/v1.13.0

----

## Eclipse
  1. Baixar o [STS - Eclipse Spring](https://spring.io/tools/sts/all)
  
  2. Descompactar o STS - Eclipse no c:\  
  
  3. Configurar o git no Eclipse  
  ![eclipse1](./img/ECLIPSE1.png)  
  ![eclipse2](./img/ECLIPSE2.png)  
  ![eclipse3](./img/ECLIPSE3.png)  
  ![eclipse4](./img/ECLIPSE4.png)  
  
  4. Configurar o JDK no Eclipse  
  ![eclipse5](./img/ECLIPSE5.png)  
  
  5. Configurar o Maven no Eclipse, utilizando a instalação externa do Maven  
  ![eclipse6](./img/ECLIPSE6.png)  
  ![eclipse7](./img/ECLIPSE7.png)  
  
  6. Configurar o formatter no Eclipse  
    1. Baixar e salvar esse [arquivo](./formatter/eclipse-formatter-v4.xml) na pasta do Eclipse  
    
    2. Clicar no botão import  
    ![eclipse8](./img/ECLIPSE8.png)  
    
    3. Utilizar o arquivo que foi baixado  
    ![eclipse9](./img/ECLIPSE9.png)  
    
  7. Configurar o auto save  
  ![eclipse10](./img/ECLIPSE10.png) 
  ----

