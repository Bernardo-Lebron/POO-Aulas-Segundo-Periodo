@echo off
cd /d "C:\Users\berna\OneDrive\Área de Trabalho\2 Periodo\Lab. de POO"

echo Puxando atualizacoes do GitHub...
git pull --rebase

echo Adicionando alteracoes...
git add .

echo Criando commit...
git commit -m "Atualizacao automatica em %date% %time%"

echo Enviando para o GitHub...
git push

echo Repositorio atualizado com sucesso!
pause
