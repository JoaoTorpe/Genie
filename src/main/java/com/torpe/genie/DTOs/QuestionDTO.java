package com.torpe.genie.DTOs;

import com.torpe.genie.Models.Options;

import java.util.ArrayList;
import java.util.List;

public record QuestionDTO(String assunto, String enunciado, List<Options> alternativas, String dica) {
}
