package model;

import java.util.Locale;

public class PC {
    private String color;
    private String cpu;
    private String gpu;

    private PC(PCBuilder pcBuilder){
        this.color = pcBuilder.color;
        this.cpu = pcBuilder.cpu;
        this.gpu = pcBuilder.gpu;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PC{");
        sb.append("color='").append(color).append('\'');
        sb.append(", cpu='").append(cpu).append('\'');
        sb.append(", gpu='").append(gpu).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class PCBuilder {
        private String color;
        private String cpu;
        private String gpu;
        public PCBuilder setColor(String color){
            this.color = color;
            return this;
        }

        public PCBuilder setCpu(String cpu){
            this.cpu = cpu;
            return this;
        }

        public PCBuilder setGpu(String gpu){
            this.gpu = gpu;
            return this;
        }

        public PC build(){
            return new PC(this);
        }
    }
}
