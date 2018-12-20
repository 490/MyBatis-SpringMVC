package controller;

import model.Fruits;

import java.util.ArrayList;
import java.util.List;

public interface FruitsService
{
    public List<Fruits> queryFruitsList();

    public Fruits queryFruitById(Integer id);

    public List<Fruits> queryFruitsByCondition(Fruits fruits);
}