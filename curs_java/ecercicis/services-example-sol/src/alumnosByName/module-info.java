module com.example.alumnosByEdad {
    requires com.example.alumnos;
    provides com.example.services.EstrategiaOrdenacion with com.example.algorithms2.AlumnoByEdad;
}
