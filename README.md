# backendConsultorioJuridico
Se crea repositorio para almacenar el backend del consultorio juridico

#Tener en cuenta
1. Para crear la base de datos, se adjunta el esquema de la base de datos en el archcivo dbConsultorioJuridico.sql
2. El backend fue creado con java 17
3. Se descarga y se ejecuta el comando para desplegar en sts o teniendo instalado maven
  mvn spring-boot:run
4. endpoints disponibles(suponiendo que se esta corriendo y probando en local):
   4.1. registrar un caso: POST: http://localhost:8080/caso
   4.2. modificar un estado del caso o tambien sirve para modificar el caso, asignandole un estudiante: PUT: http://localhost:8080/caso/3?estado=EN_PROCESO&idEstudiante=1
   4.3. registrar un comentario a un caso: POST: http://localhost:8080/comentario/caso
   4.4. Consultar los casos por estudiante: GET: http://localhost:8080/caso/estudiante/<id_estudiante>
   4.5. Consultar los comentarios de un caso: GET: http://localhost:8080/comentario/caso/<id_caso>


