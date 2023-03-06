@echo off
SET year=%1
SET month=%2
cd BDO\%year%\%month%
echo.
echo BDO\%year%\%month%\
@if exist merge.txt (
	del merge.txt
)
copy *.txt merge.txt
powershell -Command "(gc merge.txt) -replace '\t', ',' | Out-File -encoding ASCII merge.txt"
cd ../../