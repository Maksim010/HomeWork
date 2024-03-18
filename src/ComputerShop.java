//Разработать приложение, выводящее список товаров компьютерного магазина, отсортированного по цене.
// У каждого товара должны быть заданы: категория, название, артикул (уникальный код) и цена.
// Для комплектующих в категории «процессор» необходимо дополнительно указывать тактовую частоту, количество ядер и тип процессорного разъёма.
// Для комплектующих в категории «оперативная память» необходимо указывать объём в мегабайтах.
// Для комплектующих категории «видеокарты» необходимо указывать наличие активного охлаждения и объём памяти.
// Для комплектующих категории «жёсткие диски» необходимо указывать объём в гигабайтах и скорость вращения шпинделя.
// Для комплектующих категории «материнская плата» необходимо указывать наличие встроенной видеокарты, максимальный поддерживаемый объём оперативной
// памяти, тип процессорного разъёма. Для комплектующих категории «корпус» необходимо указывать мощность блока питания
// и тип корпуса (FullTower, Tower, MiniTower, Desktop). Для комплектующих категории «монитор» необходимо указывать размер диагонали экрана
// и соотношение сторон экрана. Для комплектующих категории «устройства ввода» необходимо указывать тип клавиатуры (обычная, мультимедиа)
// и количество кнопок мыши. Кроме продажи отдельных комплектующих магазин может продавать системные блоки (корпус, материнская плата, процессор,
// оперативная память, жёсткий диск, опционально: видеокарта) с надбавкой 15% за сборку или компьютеры целиком (системный блок, монитор, устройства
// ввода) с надбавкой 5% за сборку. Подсчёт стоимости товаров организовать через шаблон проектирования «Composite».
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComputerShop {
    public static void main(String[] args) {

        Processor processor1=new Processor("Intel ","1",14044.5,3,12,"Socket H4 (LGA 1151v2)");
        OpMemory opMemory1=new OpMemory("DDR4 SDRAM ","2",1100.5,4096);
        VideoCard videoCard1=new VideoCard("GeForce 4090","3",15000.0,true,16);
        HardDrive hardDrive1=new HardDrive("WD Blue","4",4300.0,2000,4);
        Motherboard motherboard1=new Motherboard("ASRock B450-m","5",9999.0,true,4,"AMD AM4");
        Case case1=new Case("Montech AIR 100","6",11000.0,5000,"Tower");
        Monitor monitor1=new Monitor("AS Rock 250","7",8900.0,22,"16/10");
        InputDevice inputDevice1=new InputDevice("Montech MKey","8",13000.0,"Default");


        Tree allComponents=new Tree(List.of(new Leaf(processor1),new Leaf(opMemory1),new Leaf(videoCard1)
                ,new Leaf((monitor1)),new Leaf(hardDrive1),new Leaf(motherboard1),new Leaf(case1),new Leaf(inputDevice1)));
        System.out.println(allComponents.countPrice());
        System.out.println(allComponents.getComponentsList());






    }
}
abstract class Component {
    protected String category;
    protected String name;
    protected String code;
    protected double price;

    public Component(String category, String name, String code, double price) {
        this.category = category;
        this.name = name;
        this.code = code;
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class Processor extends Component {
    private int clockSpeed;
    private int cores;
    private String socketType;

    public Processor(String name, String code, double price, int clockSpeed, int cores, String socketType) {
        super("Процессор", name, code, price);
        this.clockSpeed = clockSpeed;
        this.cores = cores;
        this.socketType = socketType;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }
}

class OpMemory extends Component {
    private int capacity;

    public OpMemory(String name, String code, double price, int capacity) {
        super("Оперативная память", name, code, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class VideoCard extends Component {
    private boolean hasCooling;
    private int memorySize;

    public VideoCard(String name, String code, double price,boolean hasCooling,int memorySize) {
        super("Видеокарта", name, code, price);
        this.hasCooling=hasCooling;
        this.memorySize=memorySize;
    }

    public boolean isHasCooling() {
        return hasCooling;
    }

    public void setHasCooling(boolean hasCooling) {
        this.hasCooling = hasCooling;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
}

class HardDrive extends Component {
    private int capacityGB;
    private int rotationSpeed;

    public HardDrive(String name, String code, double price,int capacityGB,int rotationSpeed) {
        super("Жесткий диск", name, code, price);
        this.capacityGB=capacityGB;
        this.rotationSpeed=rotationSpeed;

    }

    public int getCapacityGB() {
        return capacityGB;
    }

    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    public int getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(int rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }
}
    class Motherboard extends Component {
        private boolean hasIntegratedGraphics;
        private int maxMemorySupport;
        private String processorSocketType;

        public Motherboard( String name, String code, double price,boolean hasIntegratedGraphics,int maxMemorySupport,String processorSocketType) {
            super("Материанская плата", name, code,price);
            this.maxMemorySupport= maxMemorySupport;
            this.processorSocketType=processorSocketType;
            this.hasIntegratedGraphics=hasIntegratedGraphics;
        }

        public boolean isHasIntegratedGraphics() {
            return hasIntegratedGraphics;
        }

        public void setHasIntegratedGraphics(boolean hasIntegratedGraphics) {
            this.hasIntegratedGraphics = hasIntegratedGraphics;
        }

        public int getMaxMemorySupport() {
            return maxMemorySupport;
        }

        public void setMaxMemorySupport(int maxMemorySupport) {
            this.maxMemorySupport = maxMemorySupport;
        }

        public String getProcessorSocketType() {
            return processorSocketType;
        }

        public void setProcessorSocketType(String processorSocketType) {
            this.processorSocketType = processorSocketType;
        }
    }


class Case extends Component {
    private int powerSupplyPower;
    private String caseType;

    public Case( String name, String code, double price,int powerSupplyPower,String caseType) {
        super("Корпус", name, code, price);
        this.powerSupplyPower=powerSupplyPower;
        this.caseType=caseType;
    }

    public int getPowerSupplyPower() {
        return powerSupplyPower;
    }

    public void setPowerSupplyPower(int powerSupplyPower) {
        this.powerSupplyPower = powerSupplyPower;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
}

class Monitor extends Component {
    private double screenSize;
    private String aspectRatio;

    public Monitor(String name, String code, double price,double screenSize,String aspectRatio) {
        super("Moнитор", name, code, price);
        this.aspectRatio=aspectRatio;
        this.screenSize=screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}
class InputDevice extends Component {
    private String keyboardType;

    public int getMouseButtons() {
        return mouseButtons;
    }

    public void setMouseButtons(int mouseButtons) {
        this.mouseButtons = mouseButtons;
    }

    private int mouseButtons;
    public InputDevice(String category, String name, String code, double price,int mouseButtons) {
        super("Устройства ввода", name, code, price);
        this.mouseButtons=mouseButtons;
    }


    public InputDevice( String name, String code, double price,String keyboardType) {
        super("Устройства ввода", name, code, price);
        this.keyboardType=keyboardType;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }
}


    class Leaf implements Components {

        public Leaf(Component component) {
            this.component = component;
        }

        public Component getComponent() {
            return component;
        }

        private Component component;

        @Override
        public double countPrice() {
            return getComponent().price;
        }

        @Override
        public String toString() {
            return "Leaf{" +
                    "component=" + component +
                    '}';
        }
    }

class Sort implements Comparator<Component>{

    @Override
    public int compare(Component o1, Component o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}

