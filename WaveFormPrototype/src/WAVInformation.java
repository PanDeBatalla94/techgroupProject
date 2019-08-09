public class WAVInformation {
    private String header;
    private int chunksSize;
    private String waveId;

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getWaveId() {
        return waveId;
    }

    public void setWaveId(String waveId) {
        this.waveId = waveId;
    }

    public int getChunksSize() {
        return chunksSize;
    }

    public void setChunksSize(int chunksSize) {
        this.chunksSize = chunksSize;
    }
}
