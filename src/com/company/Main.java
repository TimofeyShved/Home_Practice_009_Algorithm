package com.company;

public class Main {

    public static void main(String[] args) {

        forest Gamp = new forest();

        Gamp.add(10);
        Gamp.add(15);
        Gamp.add(5);
        Gamp.add(3);
        Gamp.add(7);
        Gamp.add(1);
        Gamp.add(2);
        Gamp.add(6);
        Gamp.add(9);
        Gamp.add(13);

        System.out.println("serch get");
        Gamp.get(2);
        System.out.println();

        System.out.println();
        System.out.println("serch all");
        Gamp.getAll();

        Gamp.remove(5);
        System.out.println("serch all");
        Gamp.getAll();
    }
}

class  forest {
    int base;
    forest l, r;

    forest(){
    }

    forest(int x){
        base = x;
    }

    public void add(int x){
        if (base != x){
            if (x > base){
                if (r != null){
                    r.add(x);
                }else {
                    r = new forest(x);
                }
            }else {
                if (l != null){
                    l.add(x);
                }else {
                    l = new forest(x);
                }
            }
        }else {
            base = x;
        }
    }

    public void remove(int x){
        if (base != x){
            if (x > base){
                if (r != null){
                    r.remove(x);
                }
            }else {
                if (l != null){
                    l.remove(x);
                }
            }
        }else {
            r.migration(l);
            base = r.base;
            l = r.l;
            r = r.r;
        }
    }

    private void migration(forest l){
        if (this.l != null){
            this.l.migration(l);
        }else {
            this.l = l;
        }
    }

    public void get(int x){
        if (base != x){
            if (x>base){
                r.get(x);
            }else {
                l.get(x);
            }
        }
        System.out.print(base + " <- ");
    }

    public void getAll(){
        System.out.print(base + "|");
        if(r != null){
            r.getAll();
        }
        if(l != null){
            l.getAll();
        }
        System.out.println();
    }
}
