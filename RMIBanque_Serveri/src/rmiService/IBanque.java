package rmiService;

import metier.Compte;

public interface IBanque {
	String creerCompte(Compte c);
	String getInfoCompte(int code);
}
