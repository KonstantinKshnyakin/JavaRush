package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;
/*
Factory method pattern

Условие:

1. Внимательно посмотри, какие классы у тебя есть.
2. В отдельных файлах в пакете common создай классы JpgReader, PngReader, BmpReader, которые реализуют интерфейс ImageReader.
3. В отдельном файле в основном пакете создай класс ImageReaderFactory с одним методом.
3.1. Подумай, как он должен называться.
3.2. Подумай, какие модификаторы должны быть у этого метода.
4. Этот метод должен:
4.1. Для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
4.2. Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").


Требования:

1. Создай в пакете common класс JpgReader, реализующий интерфейс ImageReader.
2. Создай в пакете common класс PngReader, реализующий интерфейс ImageReader.
3. Создай в пакете common класс BmpReader, реализующий интерфейс ImageReader.
4. Создай публичный класс ImageReaderFactory.
5. Добавь в класс ImageReaderFactory открытый статический метод getImageReader с параметром ImageTypes.
6. Метод getImageReader должен создавать и возвращать подходящий Reader.
7. Метод getImageReader должен кидать исключение IllegalArgumentException, если передан неправильный параметр.
 */

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
        System.out.println(reader.getClass().getSimpleName());
    }
}


package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes){
        if (imageTypes == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }else if (imageTypes.equals(ImageTypes.PNG)){
            return new PngReader();
        }else if (imageTypes.equals(ImageTypes.BMP)){
            return new BmpReader();
        }else if (imageTypes.equals(ImageTypes.JPG)){
            return new JpgReader();
        }
        return null;
    }

}

package com.javarush.task.task16.task1631.common;

public enum ImageTypes {
    BMP,
    JPG,
    PNG
}

package com.javarush.task.task16.task1631.common;

public interface ImageReader {
}


package com.javarush.task.task16.task1631.common;

public class BmpReader implements ImageReader {
}

package com.javarush.task.task16.task1631.common;

public class PngReader implements ImageReader {
}

package com.javarush.task.task16.task1631.common;

public class JpgReader implements ImageReader {
}



