module com.example.alumnosByName {
    requires com.example.alumnos;
    provides com.example.services.EstrategiaOrdenacion with com.example.algorithms.AlumnoByName;
}
