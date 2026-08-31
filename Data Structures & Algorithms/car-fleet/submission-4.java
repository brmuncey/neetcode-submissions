class Car {

    int pos;
    int speed;

    public Car(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }

}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<speed.length; i++) cars.add(new Car(position[i], speed[i]));

        Collections.sort(cars, (a,b) -> b.pos - a.pos);
        Stack<Double> stack = new Stack<>();
        for(Car c : cars){
            double time =  (double)(target - c.pos)/c.speed;
            if(stack.isEmpty() || time > stack.peek()) stack.push(time);
        }
        return stack.size();
    }
}
