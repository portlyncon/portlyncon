import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


/**
 * Main program, used to read and execute commands from file
 * @author POO - teaching staff
 */
public class Main {

	private static final String SCREEN               = "SCREEN";
	private static final String KEYBOARD             = "KEYBOARD";
	
	private static final String ADD_INDIVIDUAL_ARTIST= "addIndividualArtist";
	private static final String ADD_GROUP        	 = "addGroup";
	private static final String LIST_ARTISTS         = "listArtists";
	private static final String ADD_MUSICAL_PIECE    = "addMusicalPiece";
	private static final String LIST_MUSICAL_PIECES  = "listMusicalPieces";
	private static final String ADD_AUDIO_CLIP		 = "addAudioClip";
	private static final String LIST_AUDIO_CLIPS     = "listAudioClips";
	private static final String ADD_USER	 		 = "addUser";
	private static final String ADD_FAVORITE	 	 = "addArtistToFavouriteList";
	private static final String LIST_FAVORITE        = "listFavoritesArtistByUserId";
	private static final String ADD_AC_TO_COLLECTION = "addAudioClipToPersonalCollection";
	private static final String LIST_AC_COLLECTION   = "listPersonalCollectionByUser";
	private static final String PURCHASE_AUDIOCLIP   = "purchaseAudioClip";
	private static final String ADD_CATEGORY         = "addCategory";
	private static final String LIST_CATEGORIES      = "listCategories";
	private static final String LINK_PIECE_CATEGORY  = "linkPieceToCategory";
	private static final String RATE_AUDIOCLIP		 = "rateAudioClip";
	private static final String LIST_MUSICAL_PIECES_BY_CATEGORY = "listOrderedMusicalPiecesByCategory";
	
	private static final String COMMENT_LINE         = "##";
	
	private static String       NL                   = System.getProperty("line.separator");
	
	private static final String WRONG_COMMAND        = "WRONG_COMMAND" + NL;

	private static final String EXCEPTION            = "EXCEPTION: " + NL;

	private BufferedReader      in                   = null;

	private PrintWriter         out                  = null;
	
	// Access point to all the functionalities of the program
	private UltimaFM 			ultimaFM;


	/**
	 * Build an object Main
	 * @param pIn In filename
	 * @param pOut Out filename
	 */
	public Main(String pIn, String pOut) {
	    try {
	        buildReader(pIn);
	        buildWriter(pOut);
	        ultimaFM= new UltimaFM();

	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        System.exit(-1);
	    }
	}
	
	/**
	 * Builds the out stream
	 * @param fileName
	 */
	private void buildWriter(String fileName) {
	    File dir= null;
	    if (fileName.equals(SCREEN)) {
	        out= new PrintWriter(System.out, true);
	    } else {
	        try {
	            File f;
	            if (dir != null) {
	                f= new File(dir, fileName);
	            } else {
	                f= new File(fileName);
	            }
	            out= new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f.getAbsolutePath(), false), "ISO-8859-1")));
	        } catch (IOException e) {
	            e.printStackTrace(System.err);
	        }
	    }
	}
	
	/**
	 * Builds the in stream
	 * @param fileName
	 */
	private void buildReader(String fileName) {
	    try {
	        if (fileName.equals(KEYBOARD)) {
	            in= new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
	        } else {
	            File f= new File(fileName);
	            in= new BufferedReader(new InputStreamReader(new FileInputStream(f), "ISO-8859-1"));
	        }
	    } catch (IOException e) {
	        e.printStackTrace(System.err);
	    }
	}

	/**
	 * Closes in/out streams
	 */
	public void closeStreams() {
	    try {
	        in.close();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace(System.err);
	    }
	}
	
	/**
	 * Read accesor to out stream
	 * @return out stream
	 */
	private PrintWriter getOut() {
	    return (this.out);
	}
	
	/**
	 * Main.
	 * @param args Arguments to the program
	 */
	public static void main(String[] args) {
		
	    Main p= null;
	    if (args.length == 2) {
	        p= new Main(args[0], args[1]);
	    } else {
	        System.err.println("Number of parameters incorrect, syntax is:" + NL + "\t>java Main in out");
	        System.err.println("where \tin  is " + KEYBOARD + " or InputFile");
	        System.err.println("and \tout is " + SCREEN + "   or OutputFile");
	        System.exit(-1);
	    }
	    try {
	        p.loadFile();
	        p.closeStreams();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println(e.getMessage());
	        System.exit(-1);
	    }
	}
	
	/**
	 * Load the file.
	 * @throws Exception In case of non i/o error
	 */
	public void loadFile() throws Exception {
	    String currentLine;
	    int line= 0;
	    boolean end= false;
	    while (!end) {
	        try {
	            currentLine= in.readLine();
	            line++;
	            if ((currentLine != null)) {
	                processCommand(currentLine);
	            } else {
	                end= true;
	            }
	        } catch (IOException ex) {
	            System.err.println("ex:" + ex.toString());
	            ex.printStackTrace(System.err);
	        }
	    }
	}
	
	/**
	 * Processes the line command
	 * @param currentLine
	 * @throws Exception
	 */
	private void processCommand(String currentLine) throws Exception {
	    String[] st= currentLine.trim().split(",|\\(|\\)");
	    for (int i= 0; i < st.length; i++) {
	        st[i]= st[i].trim();
	    }
	    if (st[0].startsWith(COMMENT_LINE) || st[0].trim().equals("")) {
	        this.getOut().println(currentLine);
	    } else {
	        this.getOut().println("## COMMAND ##: " + currentLine);
	        try {
	        	if (st[0].equalsIgnoreCase(ADD_INDIVIDUAL_ARTIST)) {
	                if (st.length != 5) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {

	                	Artist artist = null;
	                	// initialize  sentences according to read command:
	                	int code = Integer.parseInt(st[1]);
	                    String name = st[2];
	                    int birthYear = Integer.parseInt(st[3]);
	                    
	                    if (st[4].equals("-")) {
	                    	artist = new IndividualArtist(code,name,birthYear);	
	                    }
	                    else {
	                    	int deceaseYear = Integer.parseInt(st[4]);
	                    	artist = new IndividualArtist(code,name,birthYear,deceaseYear);
	                    }
	                    
	                    ultimaFM.addArtist(artist);
	                    
	                }

	            } else if (st[0].equalsIgnoreCase(ADD_GROUP)) {
	                if (st.length != 4) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                	int code = Integer.parseInt(st[1]);
	                    String name = st[2];
	                    int yearStarted = Integer.parseInt(st[3]);
	                    
	                    Artist artist = new Group(code, name, yearStarted);
	                    
	                    ultimaFM.addArtist(artist);
	                }

	            } else if (st[0].equalsIgnoreCase(LIST_ARTISTS)) {
	                if (st.length != 1) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	this.getOut().println(ultimaFM.listArtists());
	                }

	            }else if (st[0].equalsIgnoreCase(ADD_MUSICAL_PIECE)) {
	                if (st.length < 4) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                	int musicCode = Integer.parseInt(st[1]);
	                    String name = st[2];
	                    int initialPosition=3;
	                    int endPosition = st.length;
	                    int[] artistsCode = getArtistsCode(st, initialPosition, endPosition);
	                    
	                    ultimaFM.addMusicalPiece(musicCode, name, artistsCode);
	                }
	                
	            } else if (st[0].equalsIgnoreCase(LIST_MUSICAL_PIECES)) {
	                if (st.length != 1) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	this.getOut().println(ultimaFM.listMusicPieces());
	                }
	                
	            }else if (st[0].equalsIgnoreCase(ADD_AUDIO_CLIP)) {
	                if (st.length < 6) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {            
	                    String code = (st[1]);
	                	int musicalPieceCode = Integer.parseInt(st[2]);
	                    int duration = Integer.parseInt(st[3]);
	                    double price = Double.parseDouble(st[4]);
	                    int initialPosition=5;
	                    int endPosition = st.length;
	                    int[] artistsCode = getArtistsCode(st, initialPosition, endPosition);
	                    ultimaFM.addAudioClip(code, musicalPieceCode, duration, price, artistsCode);
	                }
	                
	            } else if (st[0].equalsIgnoreCase(LIST_AUDIO_CLIPS)) {
	                if (st.length != 1) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	this.getOut().println(ultimaFM.listAudioClips());
	                }
	                
	            } else if (st[0].equalsIgnoreCase(PURCHASE_AUDIOCLIP)) {
	                if (st.length != 3) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                	String audioClipCode = st[1];
	                    String idUser = st[2];
	                    ultimaFM.purchaseAudioClip(audioClipCode,idUser );
	                }      
	                
	                
	                
	            } else if (st[0].equalsIgnoreCase(ADD_USER)) {
	                if (st.length != 3) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                	String idUser = st[1];
	                    String name = st[2];
	                	User user = new User(idUser, name);
	                    ultimaFM.addUser(user);
	                }  
	                
	            } else if (st[0].equalsIgnoreCase(ADD_FAVORITE)) {
	                if (st.length != 3) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	String user = st[1];
	                    int artist = Integer.parseInt(st[2]);
	                    ultimaFM.addFavourite(user, artist);
	                }
	                
	            } else if (st[0].equalsIgnoreCase(LIST_FAVORITE)) {
	                if (st.length != 2) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	String userId = st[1];
	                	this.getOut().println(ultimaFM.listFavoriteArtistByUser(userId));
	                }
	            } else if (st[0].equalsIgnoreCase(ADD_AC_TO_COLLECTION)) {
	                if (st.length != 3) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	String user = st[1];
	                    String audioClipCode = (st[2]);
	                    ultimaFM.addAudioClipToPersonalCollection(user, audioClipCode);
	                }
	                
	            } else if (st[0].equalsIgnoreCase(LIST_AC_COLLECTION)) {
	                if (st.length != 2) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	String userId = st[1];
	                	this.getOut().println(ultimaFM.listPersonalCollectionByUser(userId));
	                }    
	            
	            } else if (st[0].equalsIgnoreCase(ADD_CATEGORY)) {
	                if (st.length != 4) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                	int code = Integer.parseInt(st[1]);
	                    String name = st[2];
	                    Category category = new Category(code, name);
	                    ultimaFM.addCategory(category);
	                    if (!st[3].trim().equals("-")) {
	                        int categoryIdDependent = Integer.parseInt(st[3]);
	                        ultimaFM.addSubCategory(category, categoryIdDependent);
	                    }    
	                    
	                } 
	            
	            } else if (st[0].equalsIgnoreCase(LIST_CATEGORIES)) {
	                if (st.length != 1) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	this.getOut().println(ultimaFM.listCategories());
	                }   
	                
	                
	                
	            } else if (st[0].equalsIgnoreCase(LINK_PIECE_CATEGORY)) {
	                if (st.length != 3) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                	
	                	// initialize  sentences according to read command:
	                    int musicalPieceCode  = Integer.parseInt(st[1]);
	                	int categoryId = Integer.parseInt(st[2]);
	                    ultimaFM.linkPieceToCategory(categoryId, musicalPieceCode);
	                }      
	                
	                
	            } else if (st[0].equalsIgnoreCase(RATE_AUDIOCLIP)) {
	                if (st.length != 4) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else {
	                    String audioClipCode = (st[1]);
	                	String user = st[2];
	                	int rate = Integer.parseInt(st[3]);
	                    ultimaFM.rateAudioClip(audioClipCode, user, rate);
	                }
	                  
	               
	            } else if (st[0].equalsIgnoreCase(LIST_MUSICAL_PIECES_BY_CATEGORY)) {
	                if (st.length != 2) {
	                    this.getOut().println(WRONG_COMMAND);
	                } else { 
	                	int categoryId = Integer.parseInt(st[1]);
	                	this.getOut().println(ultimaFM.listOrderedMusicalPiecesByCategory(categoryId));
	                } 
	                
	                
	                
	            }
	            else {
	            	 this.getOut().println(WRONG_COMMAND);
	            }
	        } catch (UltimaFMException ultimaFMException) {
	            this.getOut().println(ultimaFMException.getMessage());
	        } catch (Exception e) {
	            this.getOut().println(EXCEPTION);
	            e.printStackTrace();

	        }
	    	
	    }
	}	
	
	private int[] getArtistsCode(String[] st, int initialPosition, int endPosition) {
		int size = (endPosition-initialPosition);
		int[] artistsCode = new int[size];
		
		for (int i=0; i<size; i++) {
			int artistCode = Integer.parseInt(st[initialPosition+i]);
			artistsCode[i]= artistCode;	
		}
		return artistsCode;
	}
	
}