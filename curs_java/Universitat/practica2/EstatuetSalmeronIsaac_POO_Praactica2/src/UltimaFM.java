package curs_java.Universitat.practica2.EstatuetSalmeronIsaac_POO_Praactica2.src;

/*
 * UltimaFM.java
 *
 * Created on 18 de mayo de 2009, 12:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author srpopo
 */
public class UltimaFM {

    /**
     * Creem les list necessaries
     */

    private List<Artist> artistes = null;
    private List<User> users = null;;
    private List<AudioClip> audioclips = null;
    private List<Category> categories = null;
    private List<MusicalPiece> musicalpieces = null;

    private static String NL = (System.getProperty("line.separator"));

    /**
     * classe constructora de UltimaFM Inicialitzem els arrays
     */

    public UltimaFM() {

        artistes = new ArrayList<Artist>();
        users = new ArrayList<User>();
        audioclips = new ArrayList<AudioClip>();
        categories = new ArrayList<Category>();
        musicalpieces = new ArrayList<MusicalPiece>();
    }

    /**
     * Metode per afeguir un artista, si ja existeix llencem una UltimaFMException
     */

    public void addArtist(Artist artista) throws UltimaFMException {

        if (!artistes.contains(artista)) {
            artistes.add(artista);
        } else {
            throw new UltimaFMException(UltimaFMException.ARTIST_ALREADY_EXISTS);
        }
    }

    /**
     * Metode per afeguir una MusicalPiece, si l'artista no existeix llencem una
     * UltimaFMException si la MusicalPiece ja existeix llencem una
     * UltimaFMException
     */

    public void addMusicalPiece(int code, String name, int[] artistcode) throws UltimaFMException {

        List<Artist> ar = new ArrayList<Artist>();
        Artist artist = null;
        MusicalPiece mus = null;

        for (int a : artistcode) {
            if ((artist = searchArtist(a)) == null) {
                throw new UltimaFMException(UltimaFMException.ARTIST_NOT_EXIST);
            } else {
                ar.add(artist);
            }
        }

        mus = searchMusicalPiece(code);

        if (mus != null) {
            throw new UltimaFMException(UltimaFMException.MUSICAL_PIECE_ALREADY_EXISTS);
        } else {

            musicalpieces.add(new MusicalPiece(code, name, ar));
        }

    }

    /**
     * Metode per afeguir un AudioClip, si l'artista no existeix llencem una
     * UltimaFMException si la MusicalPiece no existeix llencem una
     * UltimaFMException i si l'AudioClip ja existeix llencem una UltimaFMException
     */

    public void addAudioClip(String code, int musicalPieceCode, int duration, double price, int[] artistcode)
            throws UltimaFMException {

        List<Artist> ar = new ArrayList<Artist>();
        Artist artist = null;
        MusicalPiece mus = null;
        AudioClip aud = null;

        for (int a : artistcode) {
            if ((artist = searchArtist(a)) == null) {
                throw new UltimaFMException(UltimaFMException.ARTIST_NOT_EXIST);
            } else {
                ar.add(artist);
            }
        }

        mus = searchMusicalPiece(musicalPieceCode);

        if (mus == null)
            throw new UltimaFMException(UltimaFMException.MUSICAL_PIECE_NOT_EXIST);

        aud = searchAudioClip(code);

        if (aud != null) {
            throw new UltimaFMException(UltimaFMException.AUDIO_CLIP_ALREADY_ADDED);
        }

        if (price != 0.0) {
            audioclips.add(new NonFreeAudioClip(code, duration, mus, ar, price));

        } else {
            audioclips.add(new AudioClip(code, duration, mus, ar));

        }

    }

    /**
     * Metode per afeguir un Interpret a un AudioClip, si l'Artista no existeix
     * llencem una UltimaFMException, si l'AudioClip no existeix llencem una
     * UltimaFMException
     */

    public void addInterpreter(int artistCode, String audioClipCode) throws UltimaFMException {
        Artist ar = null;
        AudioClip aud = null;

        if ((ar = searchArtist(artistCode)) == null) {
            throw new UltimaFMException(UltimaFMException.ARTIST_NOT_EXIST);

        }

        if ((aud = searchAudioClip(audioClipCode)) == null) {
            throw new UltimaFMException(UltimaFMException.AUDIO_CLIP_NOT_EXIST);
        }

        aud.addInterpreter(ar);
    }

    /**
     * Metode per afeguir un usuari, si l'usuari ja existeix llencem una
     * UltimaFMException
     */

    public void addUser(User user) throws UltimaFMException {

        if (!users.contains(user)) {
            users.add(user);
        } else {
            throw new UltimaFMException(UltimaFMException.USER_ALREADY_EXISTS);
        }
    }

    /**
     * Metode per afeguir una Categoria, si la Categoria ja existeix llencem una
     * UltimaFMException
     */

    public void addCategory(Category category) throws UltimaFMException {

        if (!categories.contains(category)) {
            categories.add(category);
        } else {
            throw new UltimaFMException(UltimaFMException.CATEGORY_ALREADY_EXISTS);
        }
    }

    /**
     * Metode per afeguir una subcategoria
     */

    public void addSubCategory(Category categoria, int categoryIdDependent) {

        Category cat = null;
        cat = (searchCategory(categoryIdDependent));
        cat.categorys.add(categoria);
    }

    /**
     * Metode per afeguir un Artista favorit a un User, si l'Artista no existeix
     * llencem una UtlimaFMException si el User no existeix llencem una
     * UtlimaFMException
     */

    public void addFavourite(String userCode, int artistCode) throws UltimaFMException {

        User us = null;
        Artist ar = null;

        if ((ar = searchArtist(artistCode)) == null) {
            throw new UltimaFMException(UltimaFMException.ARTIST_NOT_EXIST);
        }

        if ((us = searchUser(userCode)) == null) {
            throw new UltimaFMException(UltimaFMException.USER_NOT_EXIST);
        }

        us.addFavorite(ar);

    }

    /**
     * Metode per afeguir un AudioClip a la colleccio personal d'un User
     */

    public void addAudioClipToPersonalCollection(String userCode, String audioClipCode) {

        User us = null;
        AudioClip aud = null;

        us = searchUser(userCode);
        aud = searchAudioClip(audioClipCode);
        us.addAudioClip(aud);

    }

    /**
     * Metode per llistar els artistes registrats, triem entre IndividualArtist i
     * Group retornem la llista en String
     */

    public String listArtists() throws RuntimeException {

        IndividualArtist ind = null;
        StringBuffer s = new StringBuffer();
        s.append("IndividualArtist List");
        s.append(NL);

        try {
            for (Artist artistind : artistes) {

                if (artistind instanceof IndividualArtist) {

                    s.append(artistind.toString());
                    s.append(NL);
                }
            }
            s.append(NL + "GroupList" + NL);

            for (Artist artistgro : artistes) {

                if (artistgro instanceof Group) {

                    s.append(artistgro.toString());
                    s.append(NL);
                }
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    /**
     * Metode per llistar les MusicalPiece, retornme la llista en un String
     */

    public String listMusicPieces() {

        StringBuffer s = new StringBuffer();
        s.append("List of MusicalPieces");
        s.append(NL);

        for (MusicalPiece musicalpiece : musicalpieces) {

            s.append(musicalpiece.toString());
        }
        s.append(NL);

        return s.toString();
    }

    /**
     * Metode per llistar els AudioClips Registrats, retornem la llista en un String
     */

    public String listAudioClips() {

        StringBuffer s = new StringBuffer();
        s.append("List of  AudioClips");
        s.append(NL);

        for (AudioClip audioclip : audioclips) {

            s.append(audioclip.toString());
            s.append(NL);

        }
        return s.toString();
    }

    /**
     * Metode per llistar les Categories registrades, retornem la llista en un
     * String
     */

    public String listCategories() {

        StringBuffer s = new StringBuffer();
        s.append("List of  Categories");
        s.append(NL);

        for (Category categoria : categories) {

            s.append("name: " + categoria.toString());
        }
        s.append(NL);
        return s.toString();
    }

    /**
     * Metode per llistar els Artiste favorits d'un usuari, retornem la llista en un
     * String
     */

    public String listFavoriteArtistByUser(String codeUser) {

        List<Artist> list = new ArrayList<Artist>();
        StringBuffer s = new StringBuffer();
        User us = searchUser(codeUser);
        list = us.getFavorites();
        s.append("name:" + us.getName() + "The favourite artist of the user" + NL);

        for (Artist artist : list) {
            s.append(artist.toString() + NL);
        }
        return s.toString();
    }

    /**
     * Metode per llistar la colleccio personal d'AudioClips d'un user, retornme la
     * llista en un String
     */

    public String listPersonalCollectionByUser(String codeUser) {

        List<AudioClip> list = new ArrayList<AudioClip>();
        StringBuffer s = new StringBuffer();
        User us = searchUser(codeUser);
        list = us.getPersonalCollection();
        s.append("name :" + " " + us.getName() + "audioclip of de personal collection" + NL);

        for (AudioClip audioclip : list) {
            s.append(audioclip.toString() + NL);
        }
        return s.toString();
    }

    /**
     * Metode per emmagatzemar una votacio d'un user a un AudioClip, si l-usuari ja
     * la valorar llencem una UtlimaFMException
     */

    public void rateAudioClip(String audioClipCode, String userId, int value) throws UltimaFMException {

        Rating a = null;
        List<Rating> rat = new ArrayList<Rating>();
        User us = searchUser(userId);
        AudioClip aud = searchAudioClip(audioClipCode);

        rat = us.getRating();
        for (Rating rating : rat) {
            if (rating.getAudioClip().equals(aud)) {
                throw new UltimaFMException(UltimaFMException.RATING_ALREAY_ADDED);
            }
        }
        a = new Rating(aud, us, value);
        aud.musicalpiece.setAverage((double) value);// aixo es nou
        aud.musicalpiece.numvots = aud.musicalpiece.numvots + 1.0;
        us.ratings.add(a);
        aud.Ratings.add(a);

    }

    /**
     * Metode per afeguir una MusicalPiece a una Categoria, si la musicalpiece no
     * existeix llencem una UtlimaFMException
     */

    public void linkPieceToCategory(int categoryId, int musicalPieceCode) {

        MusicalPiece mus = searchMusicalPiece(musicalPieceCode);
        Category cat = searchCategory(categoryId);

        boolean a = false;
        for (MusicalPiece musical : musicalpieces) {
            if (musical.getCode() == musicalPieceCode) {
                a = true;
            }
        }
        if (!a) {
            throw new UltimaFMException(UltimaFMException.MUSICAL_PIECE_NOT_EXIST);
        } else {
            cat.musicalpieces.add(mus);
            mus.addCategories(cat);
        }
    }

    /**
     * Metode per comprar un AudioClip, si l'AudioCLip es gratis llencem una
     * UtlimaFMException
     */

    public void purchaseAudioClip(String audioClipCode, String userId) {

        AudioClip aud = searchAudioClip(audioClipCode);
        User us = searchUser(userId);

        if (aud instanceof NonFreeAudioClip) {
            us.getPurchases().add((NonFreeAudioClip) aud);
        } else
            throw new UltimaFMException(UltimaFMException.AUDIO_CLIP_FREE);
    }

    /**
     * Metode per llistar per categoria i per mitjana de vots de cada MusicalPiece,
     * retornme la llista en un String
     */

    public String listOrderedMusicalPiecesByCategory(int categoryId) {

        List<MusicalPiece> mus = new ArrayList<MusicalPiece>();
        List<AudioClip> aud = new ArrayList<AudioClip>();
        List<Category> cats = new ArrayList<Category>();
        StringBuffer s = new StringBuffer();
        s.append("List of Musical Pieces" + NL);
        Category cat = searchCategory(categoryId);

        for (MusicalPiece musicalpiece : musicalpieces) {

            cats = musicalpiece.getCategories();

            for (Category categoria : cats) {
                if (categoria.equals(cat)) {
                    mus.add(musicalpiece);
                }
            }

        }

        Collections.sort(mus);
        Collections.reverse(mus);
        for (MusicalPiece musical : mus) {

            s.append(musical.getName() + " - ");
            s.append(musical.getAverageRating() + NL);
        }

        return s.toString();

    }

    /**
     * Metode per buscar un |Artista registrat, retornem l'Artista si s'ha trobat i
     * un null si no
     */

    public Artist searchArtist(int artistcode) {

        Artist art = null;

        for (Artist artist : artistes) {

            if (artist.getCode() == artistcode) {
                art = artist;
            }
        }

        return (art);
    }

    /**
     * Metode per buscar una MusicalPiece registrada, retornem la MusicalPiece si
     * s'ha trobat i un null si no
     */

    public MusicalPiece searchMusicalPiece(int code) {
        MusicalPiece mus = null;

        for (MusicalPiece musicalpiece : musicalpieces) {

            if (musicalpiece.getCode() == code) {
                mus = musicalpiece;
            }
        }

        return (mus);
    }

    /**
     * Metode per buscar un AudioClip registrat, retornem l'AudioClip si s'ha trobat
     * i un null si no
     */

    public AudioClip searchAudioClip(String code) {
        AudioClip aud = null;

        for (AudioClip audioclip : audioclips) {
            if (audioclip.getCode().equals(code)) {
                aud = audioclip;
            }
        }
        return (aud);
    }

    /**
     * Metode per buscar una Categoria registrada, retornem la Categoria si s'ha
     * trobat i un null si no
     */

    public Category searchCategory(int categoryId) {
        Category cat = null;

        for (Category category : categories) {
            if (category.getCategoryId() == (categoryId)) {
                cat = category;
            }
        }
        return (cat);
    }

    /**
     * Metode per buscar un usuari registrat, retornem l' usuari si s'ha trobat i un
     * null si no
     */

    public User searchUser(String usercode) {
        User us = null;

        for (User user : users) {
            if (user.getUserId().equals(usercode)) {
                us = user;
            }
        }
        return (us);
    }

}
