/**IMove
 * Interface requiring that all move classes have undo, doMove, and valid methods each returning booleans
 * @author Mike Harney - mdharney@wpi.edu
 */

package move;

public interface IMove {
	public boolean undo();
	public boolean doMove();
	public boolean valid();
}
