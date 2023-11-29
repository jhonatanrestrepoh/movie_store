package co.edu.poli.user.mapper;

public interface IMapper <I, O>{
    public O mapper(I in);
}
