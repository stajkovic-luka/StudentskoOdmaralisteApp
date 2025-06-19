/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lukas
 */
public class Student implements Serializable {

    private int idStudent;
    private String ime;
    private String prezime;
    private long brTelefona;
    private boolean budzet;
    private Fakultet fakultet;
    
}
