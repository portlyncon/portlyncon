package curs_java.Universitat.practica2.EstatuetSalmeronIsaac_POO_Praactica2.src;

/**
 * @author POO - teaching staff
 */
public class UltimaFMException extends RuntimeException {
	private static final long serialVersionUID = -2495858375596972860L;

	/**
	 * Artist is already inserted
	 */
	public static final String ARTIST_ALREADY_EXISTS = "ERROR: ARTIST is already inserted.";

	/**
	 * Artist doesn't exist
	 */
	public static final String ARTIST_NOT_EXIST = "ERROR: ARTIST doesn't exist.";

	/**
	 * Musical Piece is already inserted
	 */
	public static final String MUSICAL_PIECE_ALREADY_EXISTS = "ERROR: MUSICAL PIECE is already inserted.";

	/**
	 * Musical Piece doesn't exist
	 */
	public static final String MUSICAL_PIECE_NOT_EXIST = "ERROR: MUSICAL PIECE doesn't exist.";

	/**
	 * Composer is already added to Musical Piece
	 */
	public static final String COMPOSER_IS_ALREADY_ADDED = "ERROR: COMPOSER is already added to Musical Piece.";

	/**
	 * Audio Clip is already inserted
	 */
	public static final String AUDIO_CLIP_ALREADY_EXISTS = "ERROR: AUDIO CLIP is already inserted.";

	/**
	 * Audio Clip is already added to User
	 */
	public static final String AUDIO_CLIP_ALREADY_ADDED = "ERROR: AUDIO CLIP is already added to User.";

	/**
	 * Audio Clip doesn't exist
	 */
	public static final String AUDIO_CLIP_NOT_EXIST = "ERROR: AUDIO CLIP doesn't exist.";

	/**
	 * Interpreter is already added to Audio Clip
	 */
	public static final String INTERPRETER_IS_ALREADY_ADDED = "ERROR: INTERPRETER is already added to Audio Clip.";

	/**
	 * User is already inserted
	 */
	public static final String USER_ALREADY_EXISTS = "ERROR: USER is already inserted.";

	/**
	 * User doesn't exist
	 */
	public static final String USER_NOT_EXIST = "ERROR: USER doesn't exist.";

	/**
	 * Favorite is already added to User
	 */
	public static final String FAVORITE_ALREADY_ADDED = "ERROR: FAVORITE is already added to User.";

	/**
	 * Category doesn't exist
	 */
	public static final String CATEGORY_NOT_EXIST = "ERROR: CATEGORY doesn't exist.";

	/**
	 * Category is already inserted
	 */
	public static final String CATEGORY_ALREADY_EXISTS = "ERROR: CATEGORY is already inserted.";

	/**
	 * Audioclip is already free of charge
	 */
	public static final String AUDIO_CLIP_FREE = "ERROR : AUDIO CLIP is already free of charge.";

	/**
	 * User has already evaluated the audioclip
	 */
	public static final String RATING_ALREAY_ADDED = "ERROR: User has already evaluated the audioclip.";

	/**
	 * Build an object Item
	 * 
	 * @param message Contains the error message
	 */
	public UltimaFMException(String message) {
		super(message);
	}
}
