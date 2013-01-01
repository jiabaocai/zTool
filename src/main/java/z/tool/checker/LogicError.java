/**
 * https://github.com/auzll/zTool
 */
package z.tool.checker;

/**
 * 逻辑错误
 */
public final class LogicError extends AbsError {
    
    /** */
    private static final long serialVersionUID = 7550813627149357333L;

    public LogicError(String message) {
        super(message);
    }
    
    public LogicError(String format, Object... args) {
        super(String.format(format, args));
    }
}
