package co.edu.poli.movie.mapper;

public interface IMapper <I, O>{
    public O Mapper(I in);
}
