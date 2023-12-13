package Service;

import corbaConversion.IConversionRemotePOA;

public class ConversionImpl extends IConversionRemotePOA {
    @Override
    public double conversionMontant(double mt) {
        return mt*3.2;
    }
}
