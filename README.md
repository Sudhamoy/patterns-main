# patterns

# How to start with 
Launch IntelliJ IDEA. If the Welcome screen opens, click on ‘Open’. Otherwise, from the main menu, select File | Open.
In the dialog box that opens, select the directory in which your sources, libraries and other assets are located and click on ‘Open’.

# How to run the project
cd /path-to-project
mvn spring-boot:run

# API endpoint
http://localhost:8080/v1/disease/disease-sh-io/count

http://localhost:8080/v1/disease/john-hopkins/count

http://localhost:8080/v1/disease/infected-ratio?sourceType=DiseaseSh

http://localhost:8080/v1/disease/infected-ratio?sourceType=JohnHopkins

# Sample response 
<img width="852" alt="Screenshot 2023-12-27 at 12 47 03 PM" src="https://github.com/VidyaCKabber/patterns/assets/59405528/5c3fde45-3873-4390-a034-ce3d82b1305c">
<img width="852" alt="Screenshot 2023-12-27 at 12 47 08 PM" src="https://github.com/VidyaCKabber/patterns/assets/59405528/06af6e9f-940b-4562-aa60-f2230986fec4">
<img width="852<img width="852" alt="Screenshot 2023-12-27 at 1 09 54 PM" src="https://github.com/VidyaCKabber/patterns/assets/59405528/02e039e0-a792-4ca7-af30-d9fdda461ee5">
<img width="852<img width="852" alt="Screenshot 2023-12-27 at 12 47 16 PM" src="https://github.com/VidyaCKabber/patterns/assets/59405528/b0b5ce4d-5e67-4d95-af42-1bc0dc7afaf5">

