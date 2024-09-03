package roadhog360.simpleskinbackport.client;

import net.minecraft.client.renderer.ImageBufferDownload;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class ImageBufferDownloadPlayerSkin extends ImageBufferDownload {
    @Override
    public BufferedImage parseUserSkin(BufferedImage buffImg) {
        if (buffImg == null)
            return null;
        imageWidth = 64;
        imageHeight = 64;
        BufferedImage buffImg2 = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = buffImg2.getGraphics();
        graphics.drawImage(buffImg, 0, 0, null);

        if (buffImg.getHeight() == 32) {
            graphics.drawImage(buffImg2, 24, 48, 20, 52, 4, 16, 8, 20, null);
            graphics.drawImage(buffImg2, 28, 48, 24, 52, 8, 16, 12, 20, null);
            graphics.drawImage(buffImg2, 20, 52, 16, 64, 8, 20, 12, 32, null);
            graphics.drawImage(buffImg2, 24, 52, 20, 64, 4, 20, 8, 32, null);
            graphics.drawImage(buffImg2, 28, 52, 24, 64, 0, 20, 4, 32, null);
            graphics.drawImage(buffImg2, 32, 52, 28, 64, 12, 20, 16, 32, null);
            graphics.drawImage(buffImg2, 40, 48, 36, 52, 44, 16, 48, 20, null);
            graphics.drawImage(buffImg2, 44, 48, 40, 52, 48, 16, 52, 20, null);
            graphics.drawImage(buffImg2, 36, 52, 32, 64, 48, 20, 52, 32, null);
            graphics.drawImage(buffImg2, 40, 52, 36, 64, 44, 20, 48, 32, null);
            graphics.drawImage(buffImg2, 44, 52, 40, 64, 40, 20, 44, 32, null);
            graphics.drawImage(buffImg2, 48, 52, 44, 64, 52, 20, 56, 32, null);
        }

        graphics.dispose();
        imageData = ((DataBufferInt) buffImg2.getRaster().getDataBuffer()).getData();
        setAreaOpaque(0, 0, 32, 16);
        setAreaTransparent(32, 0, 64, 32);
        setAreaOpaque(0, 16, 64, 32);
        setAreaTransparent(0, 32, 16, 48);
        setAreaTransparent(16, 32, 40, 48);
        setAreaTransparent(40, 32, 56, 48);
        setAreaTransparent(0, 48, 16, 64);
        setAreaOpaque(16, 48, 48, 64);
        setAreaTransparent(48, 48, 64, 64);
        return buffImg2;
    }
}
