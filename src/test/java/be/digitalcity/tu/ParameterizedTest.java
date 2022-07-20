package be.digitalcity.tu;

import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Test;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest {

    enum JourSemaine {
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"lundi", "mardi", "mercredi", "jeudi"})
    void estPresentDansEnum (String jour) {
        assertNotNull(JourSemaine.valueOf(jour.toUpperCase()));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @EnumSource(JourSemaine.class)
    void estPresent (JourSemaine jour) {
        assertNotNull(jour);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"lundi", "jeudi"})
    void estInclusDansEnum (String jour) {
        assertNotNull(JourSemaine.valueOf(jour.toUpperCase()));
    }

    //METHODE PAREIL QUE estInclusDansEnum, MAIS VERSION DU PROF
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"LUNDI", "JEUDI"})
    void estInclusDansEnumVersionProf (JourSemaine jour) {
        assertTrue(EnumSet.of(JourSemaine.LUNDI, JourSemaine.JEUDI).contains(jour));
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("fournisseur")
    void estInjecteParMethode(String args) {
        assertTrue((args.endsWith("e")));
    }

    static Stream<String> fournisseur() {
        return Stream.of("pomme", "poire", "banana");
    }

    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiterString = "|", numLinesToSkip = 1)
    void testAvecInjectionViaFichier(String jour, int index) {
        assertNotNull(jour);
        assertNotEquals(-1, index);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiterString = "|", numLinesToSkip = 1)
    void testAvecInjectionViaFichierAvecObjet(ArgumentsAccessor args) {
        Jour j = new Jour();
        j.setName(args.getString(0));
        j.setIndex(args.getInteger(1));
        assertNotNull(j.getName());
        assertNotEquals(-1, j.getIndex());
    }

    static class Jour {
        private String name;
        private int index;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
