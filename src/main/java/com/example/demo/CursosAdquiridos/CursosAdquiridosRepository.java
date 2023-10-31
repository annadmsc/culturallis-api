package com.example.demo.CursosAdquiridos;

import com.example.demo.CursosAdquiridos.CursosAdquiridosModel.CursosAdquiridos;
import com.example.demo.CursosAdquiridos.CursosAdquiridosModel.CursosAdquiridosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursosAdquiridosRepository extends JpaRepository<CursosAdquiridosModel, Long> {

    List<CursosAdquiridosModel> findByFkCulCursosId(Long courseId);
}
