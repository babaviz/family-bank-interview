package simple.rest.server.models.server.response;

public class SimpleServerResponse {
    private boolean error;
    private String message;

    public SimpleServerResponse() {
        error=false;
        message="";
    }

    public boolean isError() {
        return error;
    }

    public SimpleServerResponse setError(boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SimpleServerResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
